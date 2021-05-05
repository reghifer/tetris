package tools;

/**
 * <b>Pair est une classe utilitaire, permettant de regrouper deux données.</b>
 * Une pair contient deux objets de type variables :  
 * <ul>
 * <li> une clé(key) qui est le premiere attribut de la classe</li>
 * <li> une valeur(value) qui est le second attribut de la classe</li>
 * </ul>
 * 
 * @author Pierre Cartigny
 *
 */

public class Pair<T,X>{
	T key;
	X value;
	/**
	 * le constructeur de la classe Pair
	 * @param key : la premiere valeur de la paire
	 * @param value : la seconde valeur de la paire
	 */
	public Pair(T key, X value){
		this.key = key;
		this.value = value;
	}
	
	public Pair(Pair<T,X> clone) {
		this.key = clone.getKey();
		this.value = clone.getValue();
	}
	
	public void setKey(T key) {
		this.key = key;
	}


	public void setValue(X value) {
		this.value = value;
	}


	public T getKey(){
		return key;
	}
	
	public X getValue(){
		return value;
	} 
	
	/**
	 * fonction permettant de déterminé si l'objet passé en parametre est contenu dans la pair.
	 * @param o : l'objet à rechercher dans la pair
	 * @return vrai(true)si l'objet est bien présent et faux(false) sinon
	 */
	public boolean contains(Object o) {
		return key.equals(o) || value.equals(o);
	}
	
	/**
	 * fonction override, comparant la table avec un autre objet
	 * @param o : l'objet à comparer
	 * @return vrai(true) si l'objet est de type Pair, et possède une clé et une valeur identique et faux (false) sinon
	 */
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Pair) {
			Pair<?, ?> that = (Pair<?, ?>)o;
			return key.equals(that.key) && value.equals(that.value);
		}
		return false;
	}
	
	/**
	 * fonction override, permettant de calculer le code de hashage de la pair, en fonction de ses valeurs
	 * @return un entier(int) représentant le code de hashage de la table
	 */
	
	@Override
	public int hashCode() {
		return  31* key.hashCode() + 31 * value.hashCode();
	}
}