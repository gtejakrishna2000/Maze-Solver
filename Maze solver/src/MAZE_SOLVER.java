import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


    public class MAZE_SOLVER extends JFrame {

        public MAZE_SOLVER() {
            setTitle("MAZE");
            setLocation(100, 100);
//        setSize(620,480);
            setSize(1200, 480);

            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            path(new ArrayList<>(), 1, 1, new boolean[maze.length][maze[0].length]);
            System.out.println(path);
        }

        public int maze[][] = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

        public ArrayList<Integer> path = new ArrayList<>();

        @Override
        public void paint(Graphics g) {
            g.translate(50, 50);
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    Color c;
                    switch (maze[i][j]) {
                        case 1: {
                            c = Color.red;
                            break;
                        }
                        case 0: {
                            c = Color.white;
                            break;
                        }
                        default: {
                            c = Color.yellow;
                        }
                    }
                    g.setColor(c);
                    g.fillRect(40 * j, 40 * i, 40, 40);
                    g.setColor(Color.black);
                    g.drawRect(40 * j, 40 * i, 40, 40);
                }
            }

            g.translate(550, 0);
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[0].length; j++) {
                    Color c;
                    switch (maze[i][j]) {
                        case 1: {
                            c = Color.red;
                            break;
                        }
                        case 0: {
                            c = Color.white;
                            break;
                        }
                        default: {
                            c = Color.yellow;
                        }
                    }
                    g.setColor(c);
                    g.fillRect(40 * j, 40 * i, 40, 40);
                    g.setColor(Color.black);
                    g.drawRect(40 * j, 40 * i, 40, 40);
                }
            }
            for (int x : path) {
                int i = x / maze[0].length;
                int j = x % maze[0].length;
                g.setColor(Color.green);
                g.fillRect(40 * j, 40 * i, 40, 40);
            }
        }

        public int dx[] = {0, 1, 0, -1};
        public int dy[] = {1, 0, -1, 0};

        public void path(ArrayList<Integer> temp, int i, int j, boolean visit[][]) {
            if (maze[i][j] == 9) {
                temp.add(i * maze[0].length + j);
                if (path.size() == 0 || temp.size() < path.size()) {
                    path = new ArrayList<>(temp);
                }
                temp.remove(temp.size() - 1);
                return;
            }
            visit[i][j] = true;
            temp.add(i * maze[0].length + j);
            for (int x = 0; x < 4; x++) {
                int ni = i + dx[x];
                int nj = j + dy[x];
                if (ni < 0 || nj < 0 || ni >= maze.length || nj >= maze[0].length || maze[ni][nj] == 1 || visit[ni][nj])
                    continue;
                path(temp, ni, nj, visit);
            }
            visit[i][j] = false;
            temp.remove(temp.size() - 1);
        }

        public static void main(String[] args) {
            new MAZE_SOLVER();
        }
    }

