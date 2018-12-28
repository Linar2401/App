package commands;

import main.App;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheWayCommand extends Command {
    public void execute(App app) {
        int size = app.getSize() * 2;
        int[][] cellsWithPath = app.getCellsWithPath();
        boolean stop;
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        int d;
        int tmpEn = 0;
        int tmpEx = 0;
        for (int i = 0; i < size + 1; ++i) {
            if (cellsWithPath[i][0] == -2) {
                tmpEn = i;
            }
        }
        for (int j = 0; j < size + 1; ++j) {
            if (cellsWithPath[j][size] == -2) {
                tmpEx = j;
            }
        }
        cellsWithPath[tmpEn][0] = 0;
        d = 0;
        do {
            stop = true;
            for (int y = 0; y < size + 1; ++y)
                for (int x = 0; x < size + 1; ++x)
                    if (cellsWithPath[y][x] == d) {
                        for (int k = 0; k < 4; k++) {
                            if (x + dx[k] >= 0 && y + dy[k] >= 0) {
                                if (cellsWithPath[y + dy[k]][x + dx[k]] == -2) {
                                    stop = false;
                                    cellsWithPath[y + dy[k]][x + dx[k]] = d + 1;
                                }
                            }
                        }
                    }
            d++;
        } while (!stop && cellsWithPath[tmpEx][size] == -2);
        app.changeCellsWithPath(cellsWithPath);
        int len = cellsWithPath[tmpEx][size];
        int[] px = new int[size * size];
        int[] py = new int[size * size];
        int x = size;
        int y = tmpEx;
        d = len;
        while (d > 0) {
            px[d] = x;
            py[d] = y;
            d--;
            for (int k = 0; k < 4; ++k)
                if (y + dy[k] <= size - 1 && x + dx[k] <= size - 1)
                    if (cellsWithPath[y + dy[k]][x + dx[k]] == d) {
                        x = x + dx[k];
                        y = y + dy[k];
                        break;
                    }
        }
        px[0] = 0;
        py[0] = tmpEn;
        for (int i = 0; i < len + 1; ++i) {
            cellsWithPath[py[i]][px[i]] = 0;
        }
    }
}