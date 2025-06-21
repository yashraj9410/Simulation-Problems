package snakeLadder;

// problem desc - minimum number of attempts needed by the player to reach the destinatio that is 100
// player is standing at 1 and target is to reach 100
// snakes may be present in between at any value of n bw 1 to 100
// ladders may also be present


import java.util.LinkedList;
import java.util.*;
import java.util.Queue;

public class SinglePlayer {

    static class BoardPosition {
        int cell;       // current cell number
        int moves;      // number of dice throws taken to reach this cell

        BoardPosition(int cell, int moves) {
            this.cell = cell;
            this.moves = moves;
        }
    }

    public int minMoves(int numPlayers){
        Queue<BoardPosition> q  = new LinkedList<>();  // current cell, number of moves
        Map<Integer, Integer> map = new HashMap<>();  // denotes the snakes and ladder
        map.put(2,95);
        map.put(95, 8);

        boolean[] visited = new boolean[101];
        Arrays.fill(visited, false);

        q.add(new BoardPosition(1, 0));

        while(!q.isEmpty()){
            BoardPosition curr = q.poll();
            if(curr.cell == 100){
                return curr.moves;
            }
            for(int i = 1; i <= 6; i++){
                int nextCell = curr.cell + i;
                if(nextCell <= 100 && !visited[nextCell]){
                    if(map.containsKey(nextCell)){
                        nextCell = map.get(nextCell);
                    }
                    q.add(new BoardPosition(nextCell, curr.moves + 1));
                    visited[nextCell] = true;
                }
            }
        }
        return -1;   // unreachable case

    }
}
