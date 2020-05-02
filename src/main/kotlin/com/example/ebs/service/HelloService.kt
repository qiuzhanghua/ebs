package com.example.ebs.service
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ebean.DB
import io.ebean.Database
import io.ebean.DatabaseFactory
import io.ebean.SqlQuery
import io.ebean.config.DatabaseConfig
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct


@Service
class HelloService {
//    @Autowired
//    lateinit var database: Database

    private lateinit var database: Database
    private lateinit var query: SqlQuery

    @PostConstruct
    fun init() {
        val config = HikariConfig("/hikari.properties")
        val ds = HikariDataSource(config)
//        println(ds)
        val config2 = DatabaseConfig()
        config2.dataSource = ds
        database = DatabaseFactory.create(config2)
        query = database.sqlQuery("select version() v")
//        database = DB.getDefault()
    }

    fun hello(): String? {
        return query.findOne()?.getString("v")
//        return "Hello Service"
    }
}