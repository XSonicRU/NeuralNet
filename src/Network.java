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
    }

    double procceddata(double[] data) {
        for (int i = 0; i < neurs1.length; i++) {
            neurs1[i].recieve(data[i]);
        }

    }
}
