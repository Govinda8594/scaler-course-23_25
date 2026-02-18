package com.scaler.DesignPattern.factory;

import org.hibernate.query.Query;

class UserService {
    Database db;

    public UserService(Database database) {
        this.db = database;
    }

    void createUser() {
        Query q = db.createQuery(); // Gets the right Query type
        q.executeUpdate();
    }
}