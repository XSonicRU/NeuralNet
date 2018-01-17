import java.io.File;
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
        neurs1 = new Neuron[inpn];
        neurs2 = new Neuron[hiddn];
        neurs3 = new Neuron[outn];
        for (int i = 0; i < inpn; i++) {
            neurs1[i] = new Neuron();
        }
        for (int i = 0; i < hiddn; i++) {
            neurs2[i] = new Neuron();
        }
        for (int i = 0; i < outn; i++) {
            neurs3[i] = new Neuron();
        }
        for (Neuron aNeurs1 : neurs1) {
            for (Neuron aNeurs2 : neurs2) {
                aNeurs1.addConnection(new Connection(aNeurs2, new Random().nextDouble()));
            }
        }
        for (Neuron aNeurs2 : neurs2) {
            for (Neuron aNeurs3 : neurs3) {
                aNeurs2.addConnection(new Connection(aNeurs3, new Random().nextDouble()));
            }
        }

    }

    Network(File f) { //In future updates

    }

    double[] procceddata(double[] data) {
        double[] databack = new double[neurs3.length];
        for (int i = 0; i < data.length; i++) { //normalizing values
            while (data[i] > 1 || data[i] < -1) {
                data[i] = data[i] / 10;
            }
        }
        for (int i = 0; i < neurs1.length; i++) {
            neurs1[i].recieve(data[i]);
            neurs1[i].sendvalue();
        }
        for (int i = 0; i < neurs2.length; i++) {
            neurs2[i].sendvalue();
        }
        for (int i = 0; i < neurs3.length; i++) {
            databack[i] = neurs3[i].getCurval();
        }
        return databack;
    }
}
