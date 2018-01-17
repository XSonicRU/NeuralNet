import java.util.ArrayList;

class Neuron {
    private double curval = 0;
    private ArrayList<Connection> connections = new ArrayList<>();

    void recieve(double val) {
        curval += val;
    }

    void addConnection(Connection c) {
        connections.add(c);
    }

    void sendvalue() {
        double valtosend = 1 / (1 + Math.exp(-curval));
        for (Connection c : connections) {
            c.to.recieve(curval * c.w);
        }
    }

    double getCurval() {
        return curval;
    }
}