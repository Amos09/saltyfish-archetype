#### ***仓库。我们将仓库的接口定义归类在domain层，因为他和domain
entity联系紧密。仓库接口定义了和基础实施的持久化层交互契约，完成领域对应的增删改查操作。domain层的repository只是定义契约的接口，实际实现仍然由infrastructure完成。
***