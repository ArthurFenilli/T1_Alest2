import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class algoArrayListV2 {
    class charMod{
        private Character c;
        private boolean mark;

        public charMod(char c, boolean mark){
            this.c = c;
            this.mark = mark;
        }

        public char getChar(){
            return c;
        }

        public void setMark(boolean m){
            mark = m;
        }
        public boolean getMark(){
            return mark;
        }
    }
    private ArrayList<charMod> lista;

    public algoArrayListV2 (){
        lista = new ArrayList<charMod>();
    }

    public void preencheLista(){
        Path path = Paths.get("caso10.txt");//coloque aqui o arquivo que deseja-se ler!!!
        try (BufferedReader br = Files.newBufferedReader(path,Charset.defaultCharset())) {
        String linha = null;
        while ((linha = br.readLine()) != null) {
        try{
            for(int i = 0;i<linha.length();i++){
                lista.add(new charMod(linha.charAt(i),false));
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
                if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'N') || (lista.get(i).getChar() == 'N' && lista.get(i + 1).getChar() == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('A',false));

                }
                else if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'A') || (lista.get(i).getChar() == 'A' && lista.get(i + 1).getChar() == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('N',false));

                }
                else{
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('D',false));
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
            if(lista.get(i).getChar() != lista.get(i + 1).getChar()){
                if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'N') || (lista.get(i).getChar() == 'N' && lista.get(i + 1).getChar() == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('A',false));

                }
                else if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'A') || (lista.get(i).getChar() == 'A' && lista.get(i + 1).getChar() == 'D')){
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('N',false));

                }
                else{
                    lista.remove(i);
                    lista.remove(i);
                    lista.add(new charMod('D',false));
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
        //while(lista.length > 1)
        boolean mutacao = false;
        do{
        ArrayList<charMod> novaLista = new ArrayList<charMod>();
        mutacao = false;
        int i = 0;
        while( i<lista.size() - 1){
            if(lista.get(i).getMark() == false){
                int j = i + 1;
                while(lista.get(j).getMark() == true && j<lista.size() - 1){
                    j++;
                }
                if(lista.get(j).getMark() == false && lista.get(i).getChar() != lista.get(j).getChar()){
                    mutacao = true;
                    if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'N') || (lista.get(i).getChar() == 'N' && lista.get(i + 1).getChar() == 'D')){
                        lista.get(i).setMark(true);
                        lista.get(j).setMark(true);
                        novaLista.add(new charMod('A',false));

                    }
                    else if((lista.get(i).getChar() == 'D' && lista.get(i + 1).getChar() == 'A') || (lista.get(i).getChar() == 'A' && lista.get(i + 1).getChar() == 'D')){
                        lista.get(i).setMark(true);
                        lista.get(j).setMark(true);
                        novaLista.add(new charMod('N',false));

                    }
                    else{
                        lista.get(i).setMark(true);
                        lista.get(j).setMark(true);
                        novaLista.add(new charMod('D',false));
                    }
                    i = -1;
                    
                }

            }
            i++;
        }
        int count = 0;
        for(charMod c : lista){
            if(c.getMark() == false){
                novaLista.add(count, c);
                count++;
            }
        }
        lista = novaLista;
    } while(mutacao == true);

        
    }    

    public static void main(String args[]){
        algoArrayListV2 l = new algoArrayListV2();
        l.preencheLista();
        l.mutacaoV3();
        for(charMod c : l.lista){
            System.out.print(c.getChar());
        }
    }
    
}
