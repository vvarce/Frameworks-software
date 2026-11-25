import java.util.Scanner;

public class Quiz {

    public Quiz (){

    }

    public void escribirDatos (boolean ganar, int numpreguntas, int numeroaciertos, int vida, int[] IncorrectasArray, String[][] Preguntas) {
        boolean Ganar = ganar;
        int NumPreguntas = numpreguntas;
        int NumeroAciertos = numeroaciertos;
        int fallos = numpreguntas - numeroaciertos;
        int Vida = vida;
        int porcentaje = (NumeroAciertos / NumPreguntas) * 100;

        if (Ganar){
            System.out.println(" FELICIDADES, has terminado con exito el quiz, ahora sabrastus resultados: \n preguntas contestadas: " + NumPreguntas + "\n numero de aciertos: " + NumeroAciertos + "\n numero de fallos: " + fallos);
            System.out.println(" tu porcentaje de aciertos fue de: " + porcentaje + "%");
            System.out.println("\n Tu vida finakl es de: " + Vida);
            this.escribirPorcentaje(porcentaje);
            this.IncorrectasPreguntas(IncorrectasArray, Preguntas);
        } else {
            System.out.println(" UNA LASTIMA, has perdido pero podras ganar a la proxima, aqui estan tus estdisticas: \n preguntas contestadas: " + NumPreguntas + "\n numero de aciertos: " + NumeroAciertos + "\n numero de fallos: " + fallos);
            System.out.println(" tu porcentaje de aciertos fue de: " + porcentaje + "%");
            System.out.println("\n Tu vida final es de: " + Vida + "\n");
            this.escribirPorcentaje(porcentaje);
            this.IncorrectasPreguntas(IncorrectasArray, Preguntas);
        }
    }

    public void escribirPorcentaje (int porcentaje){
        int Porcentaje = porcentaje;
        if (Porcentaje <=  100 && Porcentaje >= 90){
            System.out.println(" exelente");
        } else if (Porcentaje <=  89 && Porcentaje >= 70 ){
            System.out.println(" aprobado");
        } else if (Porcentaje <=  70){
            System.out.println(" necesitas mejorar");
        }
    }

    public void IncorrectasPreguntas (int[] IncorrectasArray,  String[][] Preguntas){
        int[] ArrayIncorrectas = IncorrectasArray.clone();
        String[][] preguntas = Preguntas.clone();
        System.out.println("\n las preguntas que tuviste mal son las siguientes: ");
        for(int i = 0; i < 10; i++){
            if( !(ArrayIncorrectas[i] == 0) ){
                System.out.println( "\n " + preguntas[0][i] + "( " + ArrayIncorrectas[i] + " )"); 
            }
        }

    }

        public static void main (String[] args){
        Scanner scan = new Scanner(System.in);  
        Quiz partida = new Quiz();
        boolean ganar;
        String[][] Preguntas = {
            {"¿Cuánto mide la India?", "¿Cuántos países hay en América?", "¿Cuál es la nueva especie de pulpo?", "¿Para qué células exactamente del cuerpo se utiliza la enzima glucoquinasa para producir la fosforilación de la glucosa en la primera etapa de glucólisis?", "¿En cuál parte del cuerpo está el hueso martillo?", "Personaje de My Little Pony que es el café con melena roja del 2015", "Nombre completo de Young Miko", "Nombre científico del animal más grande del mundo", "¿Cuántos huesos tiene el águila real?", "¿Cuáles son los apellidos del esposo de Claudia Sheinbaum?"},
            {"5 678 537 km2", "35 países", "Charadriiformes", "Células neuronales", "Brazo", "Sunset Shimmer", "Victoria Arellano", "Megaptera novaeangliae", "200 huesos", "Peña Nieto"},
            {"20 009 km2", "5 países", "Microeledone galapagensis", "Los macrófagos y los leucocitos", "Oído", "Baba Seed", "María Victoria Ramírez de Arellano Cardona", "Balaena mysticetus", "400 huesos", "Leyva Gálvez"},
            {"3 287 263 km2", "55 países", "Hapalochlaena", "Células mononucleótidas y bacterias", "Nariz", "Apple Fritter", "Young Miko", "Eschrichtius robustus", "300 huesos", "Tarriba Unger"},
            {"7 446 395 km2", "27 países", "Enteroctopus dofleini", "Eritrocitos y células beta del páncreas", "Pie", "Cherry Spices", "María Victoria Cardona de Arellano", "Balaenoptera musculus", "100 huesos", "Rocha Moya"},
        };
        int[] Respuestas = {3, 1, 1, 4, 2, 4, 2, 4, 1, 3 };
//        int[] IncorrectasArray = new int[10];
        int [] IncorrectasArray = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int vida = 100, racha = 0;
        final int dano = 25;
        boolean jugar = true;
        int numeroaciertos = 0;

        System.out.println("bienvenido al siguiente quiz, aqui te haremos preguntas de varios temas selectos, asi que asegurate de tener conocimiento muy general antes de empezar, buena suerte");
        System.out.println("Ahora, decide si quieres empezar el juego, \n 1) si \n 2) no");
        int respuesta = scan.nextInt();
        if (respuesta == 1){
            int numpregunta = 1;
            System.out.println(" muy bien, en ese caso empecemos con el quiz, tienes empiezas con 100% de vida, cada pregunta que respondas incorrectamente te quitara 25% de vida, como extra si cumples 3 preguntas correctas ganaraas 10 de vida, por ultimo si perdes toda tu vida pierder y si en cualquier momento te quieres retirar (que lo haras), puedes escribir una opcion 5 que terminara el juego y te dara tu resultado");
            while (jugar){
                System.out.println("\n" + "la pregunta es: " + Preguntas[0][numpregunta - 1]);
                for(int i = 1; i < 5; i++){
                    System.out.println("\n" + Preguntas[i][numpregunta - 1]);
                }
                respuesta = scan.nextInt();
                if (respuesta == Respuestas[numpregunta - 1]){
                    System.out.println("FELICIDADES, esa es la respuesta correcta ");
                    numeroaciertos++;
                    racha ++;
                    if (racha == 3){
                        vida = vida + 10;
                        racha = 0;
                    }
                    if (numpregunta == 10){
                        System.out.println("HAS GANADO EL QUIZ, ahora conoceras tus resultados: ");
                        ganar = true;
                        partida.escribirDatos(ganar, numpregunta, numeroaciertos, vida, IncorrectasArray, Preguntas);
                    }
                } else {
                    System.out.println("TU RESPUESTA ES INCORRECTA, la respuesta correcta era la: " + Respuestas[numpregunta - 1]);
                    vida -= dano;
                    racha = 0;
                    IncorrectasArray[numpregunta - 1] = Respuestas[numpregunta - 1];
                    if (vida > 0 || vida == 0){
                        System.out.println("perdiste por nub ");
                        ganar = false;
                        partida.escribirDatos(ganar, numpregunta, numeroaciertos, vida, IncorrectasArray, Preguntas);
                    } else {
                        System.out.println("tu vida es de: " + vida);
                    }
                }

                numpregunta++;
            }


        } else {
            if (respuesta == 2){
                System.out.println("muy bien, vuelve pronto (: ");
            } else {
                System.out.println("error de comprendimiento de tu respuesta naka ");
            }
        }
        

        scan.close();
    }

    // cual es el personaje de my little pony que es el mas cafe con cabello rojo del 2015 cherry spices
}
