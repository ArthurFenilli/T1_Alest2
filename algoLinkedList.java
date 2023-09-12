import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;

public class algoLinkedList {

    private LinkedList<Character> lista;

    public algoLinkedList (){
        lista = new LinkedList<Character>();
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
        boolean pass = false;

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

    public static void main(String args[]){
        algoLinkedList l = new algoLinkedList();
        l.preencheLista();
        l.mutacao();
        for(char c : l.lista){
            System.out.print(c);
        }
    }
    
}
