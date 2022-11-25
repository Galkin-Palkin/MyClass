mod Human {
    pub enum HumanRoleData {
        ChildData(BTreeSet<ChildStatus>, i32), // i32 - family id
        ParentData(EducationDegree, CriminalRecord, i32), // i32 - family id
        TeacherData,
    }
}