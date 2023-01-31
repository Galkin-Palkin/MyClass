mod Human {
    pub enum IdentityDocument {
        RussianPassport(String, String, String, String, DateTime<Utc>), // Series, Number, GivenBy, DepartmentCode, IssueDate
        RussianBirthSertificate(String, DateTime<Utc>, String, String, DateTime<Utc>),
        // birth_place, sertificate_date, number, registration_place, registration_date
    }
}