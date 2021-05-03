package by.undrul.shapestask.warehouse;

public class TetrahedronParametr {
    private double surfaceArea;
    private double volume;

    public TetrahedronParametr(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetrahedronParametr parametr = (TetrahedronParametr) o;
        return Double.compare(parametr.surfaceArea, surfaceArea) == 0 &&
                Double.compare(parametr.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = result * prime + Double.hashCode(surfaceArea);
        result = result * prime + Double.hashCode(volume);

        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tetrahedron parameters{\n");
        sb.append(" surface area: ").append(surfaceArea).append('\n');
        sb.append(" volume: ").append(volume).append('\n');
        sb.append("}");
        return sb.toString();
    }
}
