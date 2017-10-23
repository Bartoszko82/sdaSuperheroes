package com.bartoszko.learning.superheroes.teams;

public enum TeamType {
	RED,
	BLUE,
	GREEN;

	public static boolean contains(String str){
        for( TeamType value : TeamType.values() ) {
            if(value.toString().equals(str)){
                return true;
            }
        }
        return false;
    }


}
