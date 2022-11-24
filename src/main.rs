use std::collections::BTreeSet;
use chrono::{DateTime, Utc};

fn main() {
    println!("Hello, world!");
}

struct User {
    id: i32,
    login: String,
    password_salt: String
}

enum ChildInstitutionData {
    School(String),
    KinderGarten(String)
}

struct ChildInstitution { // ???
    institution_type: ChildInstitutionData,
    address: String
}

struct ClassInfo {
    teacher_id: i32,
    students: BTreeSet<i32>,
    number: String
}