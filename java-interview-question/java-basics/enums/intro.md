# Enum:

# Enum Constructor::
    => if we want to assign a default value to enum, we can create a enum constructor.
    # Example:
    enum WEEKDAY{
        MONDAY("Day 1");
        private final String description;
        WEEKDAY(String description){
            this.description=description;
        }
    }

# Scope of Enum Constructor:
    => 
    Enum constructor can only have private or package-private modifer, setting a public identifier to enum constructor will attract a compile time error.
    