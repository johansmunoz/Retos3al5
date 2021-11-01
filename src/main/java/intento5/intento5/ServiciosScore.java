
package intento5.intento5;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiciosScore {
    
    @Autowired
    private RepositorioScore metodosCrud;
    
    public List<Score>getAll(){
        return metodosCrud.getAll();
    }
    
    public Optional<Score> getScore(int IdScore){
        return metodosCrud.getScore(IdScore);
    }
    
        public Score save(Score score) {
        if (score.getIdScore() == null) {
            return metodosCrud.save(score);
        } else {
            Optional<Score> e = metodosCrud.getScore(score.getIdScore());
            if (e.isEmpty()) {
                return metodosCrud.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> e = metodosCrud.getScore(score.getIdScore());
            if (!e.isEmpty()) {
                if (score.getCalificacion() != null) {
                    e.get().setCalificacion(score.getCalificacion());
                }
                if (score.getMensaje() != null) {
                    e.get().setMensaje(score.getMensaje());
                }
                
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return score;
            }
        }else{
            return score;
        }
    }
        public boolean deleteScore(int IdScore) {
        Boolean aBoolean = getScore(IdScore).map(score -> {
            metodosCrud.delete(score);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

