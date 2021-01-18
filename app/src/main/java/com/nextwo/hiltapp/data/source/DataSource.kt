package com.nextwo.hiltapp.data.source

import dagger.hilt.android.scopes.FragmentScoped

@FragmentScoped
class DataSource(val source: String) {
}