import java.util.ArrayList;

class Neuron {
    private double curval = 0;
    private ArrayList<Connection> connections;

    void recieve(double val) {
        curval += val;
    }

    void addConnection(Connection c) {
        connections.add(c);
    }

    void sendvalue() {
        for (Connection c : connections) {
            c.to.recieve(curval * c.w);
        }
    }
}