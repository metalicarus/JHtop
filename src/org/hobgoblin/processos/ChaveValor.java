package org.hobgoblin.processos;

public class ChaveValor {
	 private String chave;
     private String valor;

     public String getChave() {
         return this.chave;
     }
     private void setChave(String chave) {
         this.chave = chave.toUpperCase().trim();
     }
     public String getValor() {
         return this.valor;
     }
     private void setValor(String valor) {
         this.valor = valor.trim();
     }
     public ChaveValor factory(String chave, String valor) {
    	 ChaveValor cv = new ChaveValor();
    	 cv.setChave(chave);
    	 cv.setValor(valor);
    	 return cv;
     }
}
