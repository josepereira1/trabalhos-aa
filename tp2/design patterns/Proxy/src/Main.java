public class Main {
    public static void main(String[] args) {
        GoogleClass service = new GoogleClass();
        GoogleCache proxy = new GoogleCache(service);
        int N = 10;
        Client[] clients = new Client[N];
        for(int i = 0 ; i < N ; i++) {
            clients[i] = new Client(proxy);
        }
        for(int i = 0 ; i < N/2 ; i++) {
            int value = clients[i].getValue();
            System.out.println("Valor lido = "+value);
        }
        clients[N/2].setValue(3);
        for(int i = N/2 ; i < N ; i++) {
            int value = clients[i].getValue();
            System.out.println("Valor lido = "+value);
        }
    }
}
