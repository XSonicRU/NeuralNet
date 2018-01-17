import java.util.ArrayList;

class Neuron {
    private double curval;
    private ArrayList<Connection> connections;

    void recieve(double val) {
        curval = +val;
    }

    void setConnection(Connection c) {
        connections.add(c);
    }

    void sendvalue() {
        for (Connection c : connections) {
            c.to.recieve(curval * c.w);
        }
    }
}
