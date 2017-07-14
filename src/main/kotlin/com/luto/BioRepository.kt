package com.luto

import org.springframework.data.repository.CrudRepository
import org.socialsignin.spring.data.dynamodb.repository.EnableScan

/**
 * Created by furqan on 12/07/2017.
 */

@EnableScan
interface UserRepository : CrudRepository<Bio, String>