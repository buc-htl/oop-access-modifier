/**
 In der Objektorientierung kennt man so genannte Zugriffsmodifizierer (engl. access modifier), die die Rechte anderer Objekte einschränken.

 Die (Daten)-Kapselung ist eine Strategie in der objektorientierten Programmierung um ungewollte Änderungen an Objekten von „außen“ zu verhindern 
 und die Abhängigkeiten zwischen Klassen zu reduzieren. So sind einfacher Änderungen an einer Klasse möglich ohne Änderungen im gesamten Code vornehmen zu müssen.

 Zugriffsmodifizierer wie z.B. "public" können vor Klassen, Attributen oder Methoden stehen.

 Es gibt in Java vier Zugriffsmodifizierer:
 - public
 - protected
 - default (= wenn nichts angegeben)
 - private

 Es werden hier zwar alle erklärt, im Moment sind aber nur public und private für uns relevant.

 "private" ist der restriktivste Zugriffsmodifizierer. Er verbietet jeglichen Zugriff von außerhalb der Klasse. 
 Auf eine private Variable kann nur die Klasse selbst zugreifen, ebenso auf einen privaten Konstruktor, eine private Methode. 
 Klassenvariablen werden üblicherweise als private deklariert. Das Verändern der Variablen wird über passende Methoden, meist Getter und Setter ermöglicht.
 Damit erreichen wir eine (Daten)-Kapselung.

 Als "default" bezeichnet man die Zugreifbarkeit für den Fall, dass kein Zugriffsmodifizierer angegeben wurde. 
 Auf einen default Member können nur Klassen zugreifen, die sich im selben Paket wie die Klasse des Members befinden. 
 Dieser Zugriffmodifizierer wird insbesondere bei der Entwicklung von API eingesetzt.

 Mit dem Zugriffsmodifizierer "protected" ist der Zugriff nicht nur Klassen aus dem selben Package (wie "default"), sondern auch Subklassen der Klasse erlaubt. 
 Dies gilt auch, wenn die betreffenden Subklassen aus einem anderen Package sind als die Klasse des betreffenden Members. 
 Der Zugriffsmodifizierer "protected" wird verwendet, wenn es nur für Subklassen Sinn ergibt, den betreffenden Member zu verwenden.

 Der Zugriffsmodifizierer "public" gestattet sämtlichen Klassen Zugriff auf den betreffenden Member. Er ist der freizügigste Zugriffsmodifizierer. 
 Die Zugreifbarkeit public findet man hauptsächlich bei Methoden, die von anderen Klassen verwendet werden sollen.

 **/

public class Bottle {

    /*Generell möchte man nicht, dass von außen direkt auf Attribute zugegriffen werden kann. Damit würde man die Kontrolle verlieren und nicht mehr überprüfen können, welche Werte gesetzt werden. Außerdem könnte man z.B. nicht einfach den Datentyp oder den Namen ändern, ohne dass überall im Code, wo auf diese Attribute zugegriffen wird, Änderungen vorgenommen werden müssen.

    Deswegen sind Attribute in den allermeisten Fällen private!

    Von außen sichtbar sein sollte immer nur "was" die Klasse kann, aber nicht "wie" sie es macht.
   */
    private double volume;        //Größe der Flasche in ml
    private double currentLevel;  //momentaner Inhalt in ml

    /*
      Ich möchte, dass auf den Konstruktor von außen zugegriffen werden kann. Deswegen hat der den modifier public.
    */
    public Bottle(double volume) {
        this.volume = volume;
    }

    public Bottle(double volume, double currentLevel) {
        this.volume = volume;
        this.currentLevel = currentLevel;
    }

    public Bottle(){
        volume = 0;
        currentLevel = 0;
    }

    /*
      Auf folgende Methoden soll von außen zugegriffen werden können. Deswegen haben sie  den modifier public.
    */
    public String toString() {
        return "Die Flasche ist mit "+currentLevel+" ml von "+volume+" ml gefüllt.";
    }


    public void fillBottle(double v) {
        currentLevel += v;

        checkLevel();
    }

    public void emptyBottle(double l) {
        currentLevel -= l;

        checkLevel();
    }
    /*
    Diese Methode benötigen wir nur innerhalb der Klasse und soll von außerhalb nicht sichtbar sein!
    */
    private void checkLevel() {
        if (currentLevel<0 ) {
            currentLevel = 0;
        } else if (currentLevel > volume) {
            currentLevel = volume;
        }
    }

}
