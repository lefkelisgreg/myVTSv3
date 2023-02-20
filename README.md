# myVTS Application
###### Vehicle Transfer System | DSteam39
- Authors 
- it21451@hua.gr
- it22068@hua.gr
- it22106@hua.gr

## Start Database 
PostgreSQL with docker

```bash
docker run --name spb_db --rm -e  POSTGRES_PASSWORD=vts23 -e POSTGRES_DB=vts --net=host -v pgdata14:/var/lib/postgresql/data  -d postgres:14
```
___
### In Memory Users Credentials
| User     | Password    |
|----------|-------------|
| `seller` | `sellerpwd` |
| `buyer`  | `buyerpwd`  |
| `admin`  | `adminpwd`  |

___
#### Connect to Database
```bash
psql -h localhost -U postgres -d vts -p 5432 -W
```
___
## Stop Database
###### Check Containers before STOP database data
```bash
docker ps
```
Copy the container ID from "docker ps"
___

```sass
docker stop {ID}
```
___
## Flush Volume's Data
```bash
docker volume rm pgdata14
```
___

Credits
###### @author Greg Lefkelis lef * DS Team id: 39 * @project myVTSv3
