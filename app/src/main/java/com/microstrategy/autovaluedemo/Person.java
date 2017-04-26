package com.microstrategy.autovaluedemo;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.ryanharter.auto.value.gson.GsonTypeAdapter;

import java.util.Date;

@AutoValue
public abstract class Person {
    public abstract String name();


    @Nullable
    public abstract Integer gender();

    public abstract Integer age();

    @GsonTypeAdapter(BirthdateAdapter.class)
    public abstract Date birthdate();

    public abstract Address address();

    public static Builder builder() {
        return new AutoValue_Person.Builder();
    }

    public static TypeAdapter<Person> typeAdapter(Gson gson) {
        return new AutoValue_Person.GsonTypeAdapter(gson);
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract Builder name(String name);

        public abstract Builder gender(Integer gender);

        public abstract Builder age(Integer age);

        public abstract Builder birthdate(Date birthdate);

        public abstract Builder address(Address address);

        public abstract Person build();
    }
}
