package by.undrul.shapestask.entity;

import by.undrul.shapestask.observer.Observable;
import by.undrul.shapestask.observer.Observer;
import by.undrul.shapestask.observer.TetrahedronEvent;

import java.util.ArrayList;

public class Tetrahedron implements Observable {
    private int id;
    private Point apexPoint;
    private Point basePoint1;
    private Point basePoint2;
    private Point basePoint3;
    private ArrayList<Observer> observers = new ArrayList<>();

    public Tetrahedron(Point apexPoint, Point basePoint1, Point basePoint2, Point basePoint3) {
        this.apexPoint = apexPoint;
        this.basePoint1 = basePoint1;
        this.basePoint2 = basePoint2;
        this.basePoint3 = basePoint3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyObservers();
    }

    public Point getApexPoint() {
        return apexPoint;
    }

    public void setApexPoint(Point apexPoint) {
        this.apexPoint = apexPoint;
        notifyObservers();
    }

    public Point getBasePoint1() {
        return basePoint1;
    }

    public void setBasePoint1(Point basePoint1) {
        this.basePoint1 = basePoint1;
        notifyObservers();
    }

    public Point getBasePoint2() {
        return basePoint2;
    }

    public void setBasePoint2(Point basePoint2) {
        this.basePoint2 = basePoint2;
        notifyObservers();
    }

    public Point getBasePoint3() {
        return basePoint3;
    }

    public void setBasePoint3(Point basePoint3) {
        this.basePoint3 = basePoint3;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return apexPoint.equals(that.apexPoint) &&
                basePoint1.equals(that.basePoint1) &&
                basePoint2.equals(that.basePoint2) &&
                basePoint3.equals(that.basePoint3);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + apexPoint.hashCode();
        result = result * prime + basePoint1.hashCode();
        result = result * prime + basePoint2.hashCode();
        result = result * prime + basePoint3.hashCode();

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tetrahedron{\n");
        sb.append(" id: ").append(id).append('\n');
        sb.append(" apex point: ").append(apexPoint).append('\n');
        sb.append(" base point 1: ").append(basePoint1).append('\n');
        sb.append(" base point 2: ").append(basePoint2).append('\n');
        sb.append(" base point 3: ").append(basePoint3).append('\n');
        sb.append("}");
        return sb.toString();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        TetrahedronEvent event = new TetrahedronEvent(this);
        if (!observers.isEmpty()) {
            for (Observer observer : observers) {
                observer.changeParameters(event);
            }
        }
    }
}
