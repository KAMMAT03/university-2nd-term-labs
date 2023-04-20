package lab3;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import static java.awt.Color.CYAN;

public class Path {
    public static void main(String[] args) {
        System.out.println(findPath(3,16,45,5));
    }

    public static List<List<Integer>> findPath(int x, int y, int x_end, int y_end) {
        List<List<Integer>> visited = new ArrayList<>();
        try{
            BufferedImage image = ImageIO.read(new File("C:\\Users\\kamil\\IdeaProjects\\APRO2\\Projekt\\Kolos1_prep\\src\\image_og.png"));
            if (image.getRGB(x_end, y_end) != -16777216){
                return visited;
            }
            ImageIO.write(image, "png", new File("C:\\Users\\kamil\\IdeaProjects\\APRO2\\Projekt\\Kolos1_prep\\src\\image.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (!pathFinder(visited, x, y, x_end, y_end)){
            visited.clear();
        }
        return visited;
    }

    public static boolean pathFinder(List<List<Integer>> visited, int x, int y, int x_end, int y_end) {
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\kamil\\IdeaProjects\\APRO2\\Projekt\\Kolos1_prep\\src\\image.png"));
            if (image.getRGB(x, y) == -16777216) {
                List<Integer> cords = new ArrayList<>();
                cords.add(x);
                cords.add(y);
                visited.add(cords);
                image.setRGB(x, y, -1);
                ImageIO.write(image, "png", new File("C:\\Users\\kamil\\IdeaProjects\\APRO2\\Projekt\\Kolos1_prep\\src\\image.png"));
                if (x == x_end && y == y_end) {
                    return true;
                }
                if (pathFinder(visited, x - 1, y, x_end, y_end) ||
                        pathFinder(visited, x, y - 1, x_end, y_end) ||
                        pathFinder(visited, x + 1, y, x_end, y_end) ||
                        pathFinder(visited, x + 1, y + 1, x_end, y_end) ||
                        pathFinder(visited, x + 1, y - 1, x_end, y_end) ||
                        pathFinder(visited, x - 1, y - 1, x_end, y_end) ||
                        pathFinder(visited, x - 1, y + 1, x_end, y_end) ||
                        pathFinder(visited, x, y + 1, x_end, y_end)) {
                    return true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}