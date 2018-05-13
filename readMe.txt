Download Hibernate binaries 
https://sourceforge.net/projects/hibernate/files/hibernate3/3.6.10.Final/hibernate-distribution-3.6.10.Final-dist.zip/download



Eclipse Short keys
Copy lines ALT + CTR DOWN 
Rename     ALT + SFIGT + R


@ElementCollection
@Entity
@Embeddable
@Embedded
@AttributeOverrides
@AttributeOverride
@JoinTable
@JoinTable(name="!!!!!!",joinColumns=@JoinColumn(name="######"))
@JoinTable(name="AGENCY_BI_SERVER",joinColumns=@JoinColumn(name="AGENCY_ID"))
@ElementCollection
@JoinTable(name="AGENCY_BI_SERVER",joinColumns=@JoinColumn(name="AGENCY_ID"))
@GenericGenerator(name = "BINumberGenerator-uuid", strategy = "com.agency.custom.BINumberGenerator")
@CollectionId(columns = { @Column(name="AGENCY_ID_OF_BI") }, generator = "BINumberGenerator-uuid", type = @Type(type="int"))