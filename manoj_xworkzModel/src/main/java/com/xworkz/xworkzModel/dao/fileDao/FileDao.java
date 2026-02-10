package com.xworkz.xworkzModel.dao.fileDao;

import com.xworkz.xworkzModel.entity.fileentity.FileEntity;

public interface FileDao {
    FileEntity save(FileEntity fileEntity);

    String fetchFilepathById(Integer id);
}
