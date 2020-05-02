package com.example.ebs.domain

import javax.persistence.Entity

@Entity
class Animal(name: String) : BaseModel() {
    var name: String = name
    var age: Int = 0
    var type: String? = null
    var notes: String? = null
}