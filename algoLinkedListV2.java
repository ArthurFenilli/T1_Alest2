import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class algoLinkedListV2 {
    private DoubleLinkedListOfChar lista;

    public algoLinkedListV2(){
        lista = new DoubleLinkedListOfChar();
    }

    public DoubleLinkedListOfChar getLista(){
        return lista;
    }


    public void preencheLista(){
        Path path = Paths.get("caso30000k.txt");//coloque aqui o arquivo que deseja-se ler!!!
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
        //for (int i = 0; i<lista.size();i++) {
            //System.out.print(lista.get(i));
            
        //}
    
        //System.out.print(lista.size());
        //System.out.print(lista.getMarkElement());
        
    }


    public void mutacaoV2(){
        int i = 0;
        while( i<lista.size() - 1){


            if(lista.getMarkElement() == lista.getNextMarkElement()){
                lista.setMark(0);
                i++;
            }
            else{
                if(lista.getMarkElement() == 'D' && lista.getNextMarkElement() == 'N' || lista.getMarkElement() == 'N' && lista.getNextMarkElement() == 'D'  ){
                    lista.removeByMark(i);
                    lista.add('A');
                    
                }
                else if(lista.getMarkElement() == 'D' && lista.getNextMarkElement() == 'A' || lista.getMarkElement() == 'A' && lista.getNextMarkElement() == 'D'  ){
                    lista.removeByMark(i);
                    lista.add('N');

                }
                else{
                     lista.removeByMark(i);
                     lista.add('D');

                }
                if(i > 0){
                    i--;
                }
               
            }
    /* 
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
            */

        }

    }    







    public static void main(String args[]){
        algoLinkedListV2 l = new algoLinkedListV2();
        l.preencheLista();
        double start = System.currentTimeMillis();
        l.mutacaoV2();
        double fim = System.currentTimeMillis();
        for(int i =0; i<l.getLista().size();i++){
            System.out.print(l.getLista().get(i));
        }
        System.out.println("");
        System.out.println(fim - start);
    }


   
}