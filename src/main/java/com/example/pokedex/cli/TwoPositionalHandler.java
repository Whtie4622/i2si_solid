package com.example.pokedex.cli;

import com.example.pokedex.adpator.IPokemonAdaptor;
import com.example.pokedex.adpator.SqlPokemonAdaptor;
import com.example.pokedex.entity.Pokemon;
import com.example.pokedex.outputter.ConsolePokemonOutputter;
import com.example.pokedex.outputter.IPokemonOutputter;

/**
 * Since this is lowest level abstraction class, it is okay to depend directly
 * on concrete classes
 */
public class TwoPositionalHandler implements ICommandCallbackHandler {
    public void call(String[] args) {
        IPokemonAdaptor adaptor = new SqlPokemonAdaptor("jdbc:sqlite:" + args[1]);
        IPokemonOutputter outputter = new ConsolePokemonOutputter();
        Pokemon pokemon = adaptor.getPokemon(Integer.parseInt(args[0]));
        outputter.output(pokemon);
    }
}
