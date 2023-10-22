package com.example.aminehamed4twin7.services;



import com.example.aminehamed4twin7.entities.Bloc;

import java.util.List;

public interface IBlocServices {
    List<Bloc> retrieveBlocs();
    Bloc updateBloc(Bloc bloc);
    Bloc addBloc(Bloc bloc);
    Bloc retrieveBloc(long idBloc);
    void removeBloc(long idBloc);
}
