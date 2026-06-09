package com.scaler.DesignPattern.factory;

import org.hibernate.query.Query;

interface Database {
    Query createQuery(); // Factory method
}