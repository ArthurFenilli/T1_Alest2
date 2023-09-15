import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class algoArrayList {
    private ArrayList<Character> lista;

    public algoArrayList (){
        lista = new ArrayList<Character>();
    }

    public void preencheLista(){
        Path path = Paths.get("caso100k.txt");//coloque aqui o arquivo que deseja-se ler!!!
        try (BufferedReader br = Files.newBufferedReader(path,Charset.defaultCharset())) {
        String linha = null;
        while ((linha = br.readLine()) != null) {
        try{
            for(int i = 0;i<linha.length();i++){
                lista.add(linha.charAt(i));
            }
        
        }
        catch(Exception e ){
            System.out.println("Erro na leitura de linha:" + e);

        }
        }
        }
        catch (IOException e) {
            System.err.format("Erro na leitura de arquivos:" + e);
        }
        //for (char c : lista) {
            //System.out.print(c);
            
        //}
    
        //System.out.print(lista.size());
        
    }

    public void mutacao(){
        //while(lista.length > 1)
        int i = 0;
        while( i<lista.size() - 1){
            //for (char c:lista) {    //cuidado, recomendado apenas para cadeias pequenas!!!
                //System.out.print(c);
            //}
            //System.out.println(i);
            //System.out.println("");
            if(lista.get(i) != lista.get(i + 1)){
                if((lista.get(i) == 'D' && lista.get(i + 1) == 'N') || (lista.get(i) == 'N' && lista.get(i + 1) == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('A');

                }
                else if((lista.get(i) == 'D' && lista.get(i + 1) == 'A') || (lista.get(i) == 'A' && lista.get(i + 1) == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('N');

                }
                else{
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('D');
                }
                i = -1;
            }
            i++;

        }

    }

    public void mutacaoV2(){
        //Collections.sort(lista);
        //while(lista.length > 1)
        int marcador = 0;
        int i = 0;
        while( i<lista.size() - 1){
            //for (char c:lista) {    //cuidado, recomendado apenas para cadeias pequenas!!!
                //System.out.print(c);
            //}
            //System.out.println(i);
            //System.out.println("");
            if(lista.get(i) != lista.get(i + 1)){
                if((lista.get(i) == 'D' && lista.get(i + 1) == 'N') || (lista.get(i) == 'N' && lista.get(i + 1) == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('A');

                }
                else if((lista.get(i) == 'D' && lista.get(i + 1) == 'A') || (lista.get(i) == 'A' && lista.get(i + 1) == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('N');

                }
                else{
                    lista.remove(i);
                    lista.remove(i);
                    lista.add('D');
                }
                if(i == 0){
                    i = marcador;
                }
                else{
                    marcador --;
                    i = marcador;
                }
            }
            else{
                i++;
                marcador = i;

            }

        }

    }    

    public void mutacaoV3(){
        ArrayList<Character> novaLista = new ArrayList<Character>();
        int aux = 0;
        int i = 0;
        int marcador = 1;
        while(i<lista.size() - 1){
            if(lista.get(i) == lista.get(i + 1)){
                i++;
                marcador++;
            }
            else{
                if(marcador == 1){
                if((lista.get(i) == 'D' && lista.get(i + 1) == 'N') || (lista.get(i) == 'N' && lista.get(i + 1) == 'D')){
                    novaLista.add('A');
                }
                else if((lista.get(i) == 'D' && lista.get(i + 1) == 'A') || (lista.get(i) == 'A' && lista.get(i + 1) == 'D')){
                    novaLista.add('N');
                }
                else{
                    lista.add('D');
                }
                i = i + 2;

                }
                else{
                    int multiplicador = 0;
                    int primeiro = i;
                    int segundo = i + 1;
                    if(lista.get(primeiro) == lista.get(segundo)){
                        marcador ++;
                        i = segundo;
                    }
                    else{
                        do {
                            if((lista.get(primeiro) == 'D' && lista.get(segundo) == 'N') || (lista.get(primeiro) == 'N' && lista.get(segundo) == 'D')){
                                novaLista.add('A');
                            }
                            else if((lista.get(primeiro) == 'D' && lista.get(segundo) == 'A') || (lista.get(primeiro) == 'A' && lista.get(segundo) == 'D')){
                                novaLista.add('N');
                            }
                            else{
                                 lista.add('D');
                            }
                            multiplicador ++;
                            marcador --;
                            i--;
                            primeiro = i;
                            segundo = primeiro + (1 + 2 * multiplicador);
                            if(lista.get(primeiro) == lista.get(segundo)){
                                i = segundo;
                                aux = primeiro;
                                marcador ++;

                            }


                            
                        } while (lista.get(primeiro) != lista.get(segundo));

                    }
                }

            }

        }
       
    }    

    public static void main(String args[]){
        algoArrayList l = new algoArrayList();
        l.preencheLista();
        l.mutacaoV2();
        for(char c : l.lista){
            System.out.print(c);
        }
    }
    
    
}
