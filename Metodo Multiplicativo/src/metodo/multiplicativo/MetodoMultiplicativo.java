package metodo.multiplicativo;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MetodoMultiplicativo {

    public static boolean esImpar(double num) {
        if (num % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean esPar(double numero) {
        if (numero % 1 == 0) {
            return true;
        } else {
            return false;
        }
    }

    static double mcm(double a, double b) {
        double multiplo;

        if (a > b) {
            multiplo = a;
        } else {
            multiplo = b;
        }

        while (multiplo % a != 0 || multiplo % b != 0) {
            multiplo++;
        }
        return multiplo;
    }

    public static boolean relativoPrimo(int a, int b) {

        int max;
        if (a >= b) {
            max = a;
        } else {
            max = b;
        }
        int count = 0;
        for (int i = 2; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        double prom = 0;
        double promedio = 0;
        double z;
        double divisor = Math.sqrt(0.0833333333);

        int opcionSwitch = Integer.parseInt(JOptionPane.showInputDialog("Ingrese de acuerdo a lo siguiente:\n"
                + "1. Decimal\n"
                + "2. Binario"));

        switch (opcionSwitch) {

            case 1:
                int valores = 0;
                Object[] numeros = {3, 11, 13, 19, 21, 27, 29, 37, 53, 59, 61, 67, 69, 77, 83, 91};
                double x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la semilla"));
                while (esImpar(x) == false || x % 2 == 0 || x % 5 == 0) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es correcto");
                    x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la semilla"));
                }

                int t = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de t"));
                Object opcion = JOptionPane.showInputDialog(null, "S eleccione el valor de p", "Elegir", JOptionPane.QUESTION_MESSAGE, null, numeros, numeros[0]);
                int a = (200 * t) - (Integer) (opcion);
                int m = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de m"));
                int d = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de d"));
                int aux = 0;
                double[] arregl = new double[1];
                aux = m;
                int periodo;
                double sum = 0;
                int res;
                double min = 0;
                ArrayList<Integer> miArrayList = new ArrayList<Integer>();
                double divi = 0;
                double resi = 0;
                int aleatorio = 0;
                double seleccion = 0;
                if (d >= 5) {
                    res = d - 2;

                    periodo = (int) (5 * (Math.pow(m, res)));
                    for (int i = 0; i < periodo; i++) {
                        resi = (a * x) % m;
                        System.out.println(resi);
                        x = resi;
                    }
                    promedio = prom / periodo;

                    z = (promedio - 0.5) * Math.sqrt(100) / divisor;

                    if (z < 1.96) {
                        JOptionPane.showMessageDialog(null, "No se puede rechazar la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                    } else {
                        JOptionPane.showMessageDialog(null, " Se rechaza la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                    }
                }

                if (d < 5) {
                    for (int i = 1; i <= m; i++) {
                        for (int j = m; j > 0; j--) {
                            double rai = Math.sqrt(i);
                            double raj = Math.sqrt(j);
                            if (esPar(rai) == true && esPar(raj) == true) {
                                // System.out.println(rai + "   " + raj);
                                System.out.println("HOLA");
                                if ((Math.pow(rai, 2)) * (Math.pow(raj, 2)) == aux || (Math.pow(rai, 2)) + (Math.pow(raj, 2)) == aux) {

                                    if (rai != 1 && raj != 1) {
                                        min = mcm(rai, raj);
                                        System.out.println(min);
                                        periodo = (int) min;
                                        miArrayList.add(periodo);
                                    }
                                }

                            }
                        }
                    }

                    aleatorio = (int) Math.floor(Math.random() * (miArrayList.size()));
                    String resultado = "";
                    for (int i = 0; i < miArrayList.get(aleatorio); i++) {

                        resi = (a * x) % m;
                        System.out.println(resi);

                        resultado = resultado + (i + " | " + resi + "\n");
                        x = resi;
                    }
                    promedio = prom / miArrayList.get(aleatorio);
                    JOptionPane.showMessageDialog(null, "n  " + "  X\n" + resultado);

                    z = (promedio - 0.5) * Math.sqrt(100) / divisor;

                    if (z < 1.96) {
                        JOptionPane.showMessageDialog(null, "No se puede rechazar la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                    } else {
                        JOptionPane.showMessageDialog(null, " Se rechaza la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                    }
                }

                break;

            case 2:

                int mBinario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor m"));
                double promocion = mBinario / 4;
                int semilla = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de la semilla"));
                while (esImpar(semilla) == false || relativoPrimo(semilla, mBinario) == false) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no corresponde a un valor impar");
                    semilla = Integer.parseInt(JOptionPane.showInputDialog("Ingrese nuevamente el valor de la semilla"));
                }
                int tBinario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor t"));
                int aBinario = 8 * (tBinario) + 3;

                int serie = 0;
                String auxi = "";
                for (int i = 0; i <= promocion; i++) {
                    serie = aBinario * semilla % mBinario;
                    auxi = auxi + (i + " | " + serie + "\n");
                    semilla = serie;
                    prom = prom + serie;
                }
                promedio = prom / promocion;
                JOptionPane.showMessageDialog(null, "n  " + "  Xn\n" + auxi);

                //System.out.println(promedio + "   " + prom + "  " + promocion);
                z = (promedio - 0.5) * Math.sqrt(100) / divisor;

                if (z < 1.96) {
                    JOptionPane.showMessageDialog(null, "No se puede rechazar la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                } else {
                    JOptionPane.showMessageDialog(null, " Se rechaza la hipotesis de que estos numeros pseudoaleatorios tienen una media de 0.5");
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "El valor ingresado no es correcto");
        }

    }

}
