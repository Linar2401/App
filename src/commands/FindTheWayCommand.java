package commands;

import main.App;

import java.util.ArrayList;

public class FindTheWayCommand extends Command {
    public void execute(App app) {
        app = app;
        //Это место работы Загира.Все должно записаться вместе с лабиринтом в char[][] cellsWithPathpublic class Li {
        int[][] cellsWithPath = app.getCells();
        boolean stop;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int d = 0;
        int tmpEn = 0;
        int tmpEx = 0;
        for (int i = 0; i < app.getSize(); ++i) {
            if (cellsWithPath[i][0] == -2) {
                tmpEn = i;
            }
        }
        for (int j = 0; j < app.getSize(); ++j) {
            if (cellsWithPath[j][app.getSize()] == -2) {
                tmpEx = j;
            }
        }
        cellsWithPath[tmpEn][0] = 0;
        do {
            stop = true;
            for (int y = 0; y < app.getSize(); y++)
                for (int x = 0; x < app.getSize(); ++x)
                    if (cellsWithPath[y][x] == d) {
                        for (int k = 0; k < 4; ++k) {
                            if (x + dx[k]>=0 && y + dy[k]>=0) {
                                if (cellsWithPath[y + dy[k]][x + dx[k]] == -2) {
                                    stop = false;
                                    cellsWithPath[y + dy[k]][x + dx[k]] = d + 1;
                                }
                            }
                        }
                    }
            d++;
        } while (!stop && cellsWithPath[tmpEx][app.getSize()] == -2);
        app.changeCellsWithPath(cellsWithPath);
    }
}
