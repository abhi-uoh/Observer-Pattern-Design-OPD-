public class ObserverPattern {
    public static void main(String[] args) {
        ScoreBoardImpl sb = new ScoreBoardImpl();


        Observer observer1 = new ObserverImpl("observer1");
        Observer observer2 = new ObserverImpl("observer2");
        Observer observer3 = new ObserverImpl("observer3");
        Observer observer4 = new ObserverImpl("observer4");

        Observer observer5 = new ObserverImpl("observer5");
        sb.register(observer1);
        sb.register(observer2);
        sb.register(observer3);
        sb.register(observer4);
        sb.register(observer5);

        observer1.subscribe(sb); // both way handshake
        observer2.subscribe(sb); // both way handshake
        observer3.subscribe(sb); // both way handshake
        observer4.subscribe(sb); // both way handshake
        observer5.subscribe(sb);

//        observer1.update();

        sb.postMessage("IPL RUN : 160/4");
//        sb.unregister(observer2);
        sb.postMessage("IPL RUN : 180/7");
        sb.postMessage(("IPL RUN : 220/10"));



    }
}
