import java.util.Random;

public class Network {
    private Neuron[] neurs1;
    private Neuron[] neurs2;
    private Neuron[] neurs3;

    Network(int inpn, int hiddn, int outn) {
        if (inpn == 0 || hiddn == 0 || outn == 0) { //Just in case)
            System.out.println("ERROR!");
            System.exit(0);
        }


        for (int i = 0; i < inpn; i++) {
            neurs1[i] = new Neuron();
        }
        for (int i = 0; i < hiddn; i++) {
            neurs2[i] = new Neuron();
        }
        for (int i = 0; i < neurs1.length; i++) {
            for (int j = 0; j < neurs2.length; j++) {
                neurs1[i].addConnection(new Connection(neurs2[j], new Random().nextDouble()));
            }
        }
        for (Neuron n : neurs2) {
            n.sendvalue();
        }

    }

    double procceddata(double[] data) {
        for (int i = 0; i < neurs1.length; i++) {
            neurs1[i].recieve(data[i]);
            neurs1[i].sendvalue();
        }


        return 0; //TODO
    }
}
