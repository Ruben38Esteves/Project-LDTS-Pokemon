package org.example.model;

public class Position {
    private int x;
    private int y;
    public Position(int x1, int y1){
        x=x1;
        y=y1;
    }
    public Position getLeft() {
        return new Position(x - 5, y);
    }

    public Position getRight() {
        return new Position(x + 5, y);
    }

    public Position getUp() {
        return new Position(x, y - 5);
    }

    public Position getDown() {
        return new Position(x, y + 5);
    }
    public void set_x(int x){
        this.x=x;
    }
    public void set_y(int y){
        this.y=y;
    }
    public int get_x(){
        return this.x;
    }
    public int get_y(){
        return this.y;
    }
    public void changeTo(Position position){
        set_x(position.get_x());
        set_y(position.get_y());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Position p = (Position) o;
        return x == p.get_x() && y == p.get_y();
    }
}
