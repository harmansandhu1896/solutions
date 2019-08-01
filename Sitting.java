// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Sitting {

    class Seat {
        int row;
        String column;
        Seat(int row, String column){
            this.row = row;
            this.column = column;
        }
    }

    class Sortbyrow implements Comparator<Seat>
    {

        public int compare(Seat a, Seat b)
        {
            return a.row - b.row;
        }
    }

    public int solution(int N, String S) {
        // write your code in Java SE 8
        String[] arrOfStr = S.split(" ",0);
        int countFamilies = 0;
        List<Seat> seats = new ArrayList<>();
        Set<String> seatSet1 = new HashSet<>(Arrays.asList("A","B","C"));
        Set<String> seatSet2 = new HashSet<>(Arrays.asList("D","E","F","G"));
        Set<String> seatSet3 = new HashSet<>(Arrays.asList("H","J","K"));
        if(arrOfStr.length > 0 && !S.isEmpty()){
            for(String seat : arrOfStr){
                String column = seat.substring(seat.length()-1);
                int row = Integer.parseInt(seat.replace(column, ""));
                Seat newSeat = new Seat(row, column);
                seats.add(newSeat);
            }

            Collections.sort(seats, new Sortbyrow());

            Map<Integer, Set<String>> rowSeatMap = new HashMap<>();
            for(Seat seat : seats){
                if(!rowSeatMap.containsKey(seat.row)){
                    rowSeatMap.put(seat.row, new HashSet<>());
                }
                rowSeatMap.get(seat.row).add(seat.column);
            }

            for(int i=0; i<N; i++){
                if(rowSeatMap.containsKey(i+1)){
                    Set<String> columnNames = rowSeatMap.get(i+1);

                    Set<String> set1Copy = new HashSet<>(seatSet1);
                    Set<String> set2Copy = new HashSet<>(seatSet2);
                    Set<String> set3Copy = new HashSet<>(seatSet3);

                    set1Copy.retainAll(columnNames);
                    set2Copy.retainAll(columnNames);
                    set3Copy.retainAll(columnNames);

                    if(set1Copy.size() == 0){
                        countFamilies++;
                    }

                    if(set2Copy.size() == 0){
                        countFamilies++;
                    }else{
                        Set<String>  middleSet = new HashSet<>(Arrays.asList("E","F"));
                        if(set2Copy.size() == 1){
                            middleSet.retainAll(set2Copy);
                            if(middleSet.size() == 0){
                                countFamilies++;
                            }
                        }
                    }

                    if(set3Copy.size()==0){
                        countFamilies++;
                    }

                }else{
                    countFamilies = countFamilies + 3;
                }
            }

        }else{
            countFamilies = 3*N;
        }
        return countFamilies;
    }
}