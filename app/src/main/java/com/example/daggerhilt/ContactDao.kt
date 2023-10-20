package com.example.daggerhilt

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao{

	@Upsert
	suspend fun upsertContact(contact : Contact)

	@Delete
	suspend fun deleteContact(contact : Contact)

	@Query("SELECT * from contact Order By firstName ASC")
	 fun getContactsOrderedByFirstName():Flow<List<Contact>>

	@Query("SELECT * from contact Order By lastName ASC")
	 fun getContactsOrderedByLastName():Flow<List<Contact>>

	@Query("SELECT * from contact Order By phoneNumber ASC")
	fun getContactsOrderedByPhoneNumber():Flow<List<Contact>>
}