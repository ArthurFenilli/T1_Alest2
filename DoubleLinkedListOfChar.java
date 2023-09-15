public class DoubleLinkedListOfChar {
       // Referencia para o sentinela de inicio da lista encadeada.
       private Node header;
       // Referencia para o sentinela de fim da lista encadeada.
       private Node trailer;  
       // Contador do numero de elementos da lista.
       private Node mark;
       private int count;
   
        private class Node {
           public Character element;
           public Node next;
           public Node prev;
           public Node(Character e) {
               element = e;
               next = null;
               prev = null;
           }
       }
   
       public DoubleLinkedListOfChar() {
           header = new Node(null);
           trailer = new Node(null);
           mark = new Node(null);
           header.next = trailer;
           trailer.prev = header;
           count = 0;
       }
   
       /**
        * Adiciona um elemento ao final da lista
        * @param element elemento a ser adicionado ao final da lista
        */
       public void add(char element) {
           // Primeiro cria o nodo
           Node n = new Node(element);
           if(count == 0){
            mark = n;
           }
           // Conecta o nodo criado na lista
           n.prev = trailer.prev;
           n.next = trailer;
           // Atualiza os encadeamentos
           trailer.prev.next = n;
           trailer.prev = n;
           // Atualiza count
           count++;        
       }
       
       /**
        * Insere um elemento em uma determinada posicao da lista
        * @param index a posicao da lista onde o elemento sera inserido
        * @param element elemento a ser inserido
        * @throws IndexOutOfBoundsException se (index < 0 || index > size())
        */
       public void add(int index, char element) throws IndexOutOfBoundsException {
           // Primeiro verifica se index eh valido 
           if (index < 0 || index > count )
               throw new IndexOutOfBoundsException();
           
           if( index == count ) {
               add(element); // insere no final
           }
           else {
               // Primeiro cria o nodo
               Node n = new Node(element);
               // Caminha ate a posicao index
               Node aux = getNodeIndex(index);
               // Conecta o novo nodo na lista
               n.next = aux;
               n.prev = aux.prev;
               // Atualiza as referencias para apontarem para o novo nodo
               aux.prev.next = n;
               aux.prev = n;
               // Atualiza o count
               count++;
           }
       }
       
       /**
        * Remove a primeira ocorrencia do elemento na lista, se estiver presente
        * @param element o elemento a ser removido
        * @return true se a lista contem o elemento especificado
        */
       public boolean remove(char element) {
           Node aux = header.next;
           for(int i=0; i<count;i++) {
               if (aux.element.equals(element)) { 
                   aux.prev.next = aux.next;
                   aux.next.prev = aux.prev;
                   count--;               
                   return true;
               }
               aux = aux.next;
           }
           return false;	
       }
       
       /**
        * Remove o elemento de uma determinada posicao da lista
        * @param index a posicao da lista
        * @return o elemento que foi removido da lista
        * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
        */
       public char removeByIndex(int index) {
           // Primeiro verifica se index eh valido
           if (index < 0 || index >= count) {
               throw new IndexOutOfBoundsException();
           }        
           
           // "Caminha" ate a posicao index
           Node aux = getNodeIndex(index);
           
           // Faz a remocao
           aux.prev.next = aux.next;
           aux.next.prev = aux.prev;
           count--;
           
           // Retorna o elemento removido
           return aux.element;
       }
   
       /**
        * Retorna o elemento de uma determinada posicao da lista
        * @param index a posicao da lista
        * @return o elemento da posicao especificada
        * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
        */
       public char get(int index) {
           // Primeiro verifica se index eh valido
           if ((index < 0) || (index >= count)) {
               throw new IndexOutOfBoundsException();
           }
           Node aux = getNodeIndex(index);
           return aux.element;
       }
       
       // Metodo privado usado por outros metodos desta classe.
       // Tem como objetivo retornar uma referencia para o
       // nodo da posicao index recebida por parametro.
       private Node getNodeIndex(int index) {
           Node aux = null;
           
           if (index < count/2) { // caminha do início para o meio
               aux = header.next;
               for(int i=0; i<index; i++) {
                   aux = aux.next;
               }
           }
           else { // caminha do fim para o meio
               aux = trailer.prev;
               for(int i=count-1; i>index; i--) {
                   aux = aux.prev;
               }
           }
       
           return aux;
       }    
       
      /**
       * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
       * @param index a posicao da lista
       * @param element o elemento a ser armazenado na lista
       * @return o elemento armazenado anteriormente na posicao da lista
       * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
       */
       public char set(int index, char element) {
           // Primeiro verifica se index eh valido
           if ((index < 0) || (index >= count)) {
               throw new IndexOutOfBoundsException();
           }
           Node aux = getNodeIndex(index);
           char elem = aux.element;
           aux.element = element;
           return elem;
       }    
       
       
       /**
        * Retorna true se a lista contem o elemento especificado
        * @param element o elemento a ser testado
        * @return true se a lista contém o elemento especificado
        */
       public boolean contains(char element) {
           Node aux = header.next;
           for(int i=0; i<count; i++) {
               if (aux.element.equals(element)) {
                   return true;
               }
               aux = aux.next;
           }
           return false;
       }
       
       /**
        * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
        * @param element o elemento a ser buscado
        * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
        */
       public int indexOf(char element) {
           Node aux = header.next;
           for(int i=0; i<count; i++) {
               if (aux.element.equals(element)) {
                   return i;
               }
               aux = aux.next;
           }
           return -1;
       }
       
       /**
        * Esvazia a lista
        */
       public void clear() {
           header = new Node(null);
           trailer = new Node(null);
           header.next = trailer;
           trailer.prev = header;
           count = 0;
       }    
           
       /**
        * Retorna o numero de elementos da lista
        * @return o numero de elementos da lista
        */
       public int size() {
           return count;
       }
       
       /**
        * Retorna true se a lista não contem elementos
        * @return true se a lista não contem elementos
        */
       public boolean isEmpty() {
           return (count == 0);
       }
           
       @Override
       public String toString()
       {
           StringBuilder s = new StringBuilder();
           Node aux = header.next;
           for (int i = 0; i < count; i++) {
               s.append(aux.element.toString());
               s.append("\n");
               aux = aux.next;
           }
           return s.toString();
       }
       
       public void setMark(int b){
        if(b == 0){
            mark = mark.next;
        }
        else if(b == 1){
            mark = header.next;
        }
        }

        public char getMarkElement(){
            return mark.element;
        }
    
        public char getNextMarkElement(){
            return mark.next.element;
        }
        
        public void removeByMark(int i){
           // Primeiro verifica se index eh valido
           if (i < 0 || i>= count) {
               throw new IndexOutOfBoundsException();
           }        
           
           // "Caminha" ate a posicao index
           Node aux = mark.next;
           
           
           // Faz a remocao
           aux.prev.next = aux.next;
           aux.next.prev = aux.prev;
           count--;
           if(i == 0){
            aux = mark;
            mark = mark.next;
           }
           else{
            aux = mark;
            mark = mark.prev;
           }
           aux.prev.next = aux.next;
           aux.next.prev = aux.prev;
           count--;
           
        }


    
}
