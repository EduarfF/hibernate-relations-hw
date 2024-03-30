package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.ActorDao;
import mate.academy.hibernate.relations.model.Actor;
import mate.academy.hibernate.relations.service.ActorService;

public class ActorServiceImpl implements ActorService {
    private ActorDao actorDao;

    public ActorServiceImpl(ActorDao actorDao) {
        this.actorDao = actorDao;
    }

    @Override
    public Actor add(Actor actor) {
        if (actor == null) {
            throw new RuntimeException("Cannot add null data");
        }
        actorDao.add(actor);
        return actor;
    }

    @Override
    public Actor get(Long id) {
        if (id == null) {
            throw new RuntimeException("Cannot get by null id");
        }
        return actorDao.get(id)
                        .orElseThrow(() -> new RuntimeException("No actor found with id: " + id));
    }
}
