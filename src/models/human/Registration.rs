mod Human {
    pub enum Registration {
        Permanent(String, String, String, Datetime<Utc>), // address, department_name, department_code, registration_date
        Temporary(String, String, DateTime<Utc>, DateTime<Utc>, DateTime<Utc>, String)
        // number, address, registration_date, date_from, date_to, department_name
    }
}