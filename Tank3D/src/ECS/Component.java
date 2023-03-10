package ECS;

public abstract class Component {
    protected Entity parent;

    public Component(Entity parent) {
        this.parent = parent;
    }
    
    public abstract void update(ESystem eSystem);
}
