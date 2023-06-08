# Github-API-Automation
This is a project using SpringBoot, MongoDB, Gradle and GITHUB Api

- ####   /public/repos/{username}

    Use : `To get the details of all repos of user X` \
    Format :  `GET Request`

- ####   /public/repos/save/{username}

    Use : `To save the details of all repos of user X in MongoDB` \
    Format :  `GET Request`

- ####   /local/all

    Use : `To get the details of all repos of all users from MongoDB` \
    Format :  `GET Request`

- ####   /local/repos/username/{username}

    Use : `To get the details of all repos of user X from MongoDB` \
    Format :  `GET Request`

- ####   /local/repos/keyword/{keyword}

    Use : `To get the details of all repos containing keyword X from MongoDB` \
    Format :  `GET Request`

- ####   /local/repos/sort/{username}

    Use : `To get the details of all repos of user X from MongoDB in sorted order according to Creation Time` \
    Format :  `GET Request`

- ####   /local/repos/delete/{username}

    Use : `To delete the details of all repos of user X from MongoDB` \
    Format :  `GET Request`

- ####   /me/create/repo

    Use : `To create a repo in Github` \
    Format :  `POST Request` \
    Body :  `{
                "token": XXXX,
                "name": "RepoName",
                "description": "RepoDescription",
                "homepage": "https://github.com",
                "isPrivate": false,
                "isTemplate": true
            }`

Tasks to do next:
1. Add Reddit API as well
2. Try out integrating github actions through this