mod Class {
    pub struct ClassInfo {
        id: i32,
        teacher_id: i32,
        students: BTreeSet<i32>,
        number: ClassNumber
    }
}